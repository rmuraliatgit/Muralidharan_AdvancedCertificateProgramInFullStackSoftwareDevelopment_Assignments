import React, { useState, useEffect } from 'react';
import axios from 'axios';
import MovieList from './components/MovieList';
import SearchBar from './components/SearchBar';
import MovieDetails from './components/MovieDetails';
import { Movie } from './components/Movie'
import { ToastContainer, toast } from 'react-toastify';
import './App.css';
import 'react-toastify/dist/ReactToastify.css';


export enum MovieSection {
  InTheatre = 'Movies in Theatre',
  ComingSoon = 'Coming Soon',
  TopRatedIndian = 'Top Rated Indian',
  TopRatedMovies = 'Top Rated Movies',
  Favorites = 'Favorites',
}

const App: React.FC = () => {
  const addedToFav = () => toast("Added to Fav",{ type:"success"});
  const alreadyAddedToFav = ()=>toast("Already Added to Fav",{ type:"error"});
  const removedFromFav = () => toast("Removed from Fav",{ type:"success"});
  const [isLoading, setIsLoading] = useState<boolean>(true);
  const [filteredMovies, setFilteredMovies] = useState<Movie[]>([]);
  const [isSearchActive, setIsSearchActive] = useState(false);
  const [searchTerm, setSearchTerm] = useState<string>('');
  const [selectedMovies, setSelectedMovies] = useState<Movie[]>([]);
  const [favoriteMovies, setFavoriteMovies] = useState<Movie[]>([]);
  const [selectedSection, setSelectedSection] = useState<MovieSection>(MovieSection.InTheatre);
  const [selectedMovie, setSelectedMovie] = useState<Movie | null>(null);
  const [movieSections, setMovieSections] = useState<Record<MovieSection, Movie[]>>({
    [MovieSection.InTheatre]: [],
    [MovieSection.ComingSoon]: [],
    [MovieSection.TopRatedIndian]: [],
    [MovieSection.TopRatedMovies]: [],
    [MovieSection.Favorites]: [],
  });
  
  useEffect(() => {
    if(searchTerm) handleSearch();
  }, [searchTerm]);

  const fetchData = async () => {
    
    try {

       // setIsLoading(true);
      const [comingSoonResponse, inTheatersResponse, topRatedIndianResponse, topRatedMoviesResponse, favoriteResponse] =
        await Promise.all([
          axios.get('http://localhost:3001/movies-coming'),
          axios.get('http://localhost:3001/movies-in-theaters'),
          axios.get('http://localhost:3001/top-rated-india'),
          axios.get('http://localhost:3001/top-rated-movies'),
          axios.get('http://localhost:3001/favourite')
        ]);
        console.log(inTheatersResponse,"in theatre response");
        
      const comingSoonMovies: Movie[] = comingSoonResponse.data;
      const inTheatersMovies: Movie[] = inTheatersResponse.data;
      const topRatedIndianMovies: Movie[] = topRatedIndianResponse.data;
      const topRatedMovies: Movie[] = topRatedMoviesResponse.data;
      const favoriteMovies: Movie[] = favoriteResponse.data;
      if(favoriteMovies.length>0){
        setFavoriteMovies(favoriteMovies); 
      }
      const movieSections = {
        [MovieSection.InTheatre]: inTheatersMovies,
        [MovieSection.ComingSoon]: comingSoonMovies,
        [MovieSection.TopRatedIndian]: topRatedIndianMovies,
        [MovieSection.TopRatedMovies]: topRatedMovies,
        [MovieSection.Favorites]: favoriteMovies
      };
      setMovieSections(movieSections); 
      setSelectedMovies(inTheatersMovies);
      // setIsLoading(false);

    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };
  useEffect(() => {
    fetchData();
  }, []);
  
  const handleSearch = () => {
    const sections = Object.values(MovieSection).filter(
      (section) => section !== MovieSection.Favorites
    );
    let filtered: Movie[] = [];
  
    sections.forEach((section) => {
      const movies = movieSections[section];
      const filteredMovies = movies.filter((movie: Movie) =>
        movie.title.toLowerCase().includes(searchTerm.toLowerCase())
      );

      filtered = [...filtered, ...filteredMovies];
    });
    setFilteredMovies(filtered);
    setIsSearchActive(true);
  };

  const handleMovieClick = (movie: Movie) => {
    setSelectedMovie(movie);
  };

  const handleSectionChange = (section: MovieSection) => {
    setSelectedSection(section);
    if (searchTerm) {
      const filtered = selectedMovies.filter((movie: Movie) =>
        movie.title.toLowerCase().includes(searchTerm.toLowerCase())
      );
      setSelectedMovies(filtered);
    } else {
      setSelectedMovies(movieSections[section]);
    }
    setIsSearchActive(false);
  };
  
  const handleFavorite = async (movie: Movie) => {
    const isFavorite = favoriteMovies.some((favMovie) => favMovie.id === movie.id);
    if (isFavorite) {
      try {
        if (selectedSection === MovieSection.Favorites) {
          await axios.delete(`http://localhost:3001/favourite/${movie.id}`);
          const updatedFavorites = favoriteMovies.filter((favMovie) => favMovie.id !== movie.id);
          setFavoriteMovies(updatedFavorites);
          setMovieSections({
            ...movieSections,
            [MovieSection.Favorites]: updatedFavorites,
          });
          setSelectedMovies(updatedFavorites);
          removedFromFav();
        } else {
          alreadyAddedToFav();
        }
      } catch (error) {
        alreadyAddedToFav();
      }
    } else {
      try {
        const response = await axios.post('http://localhost:3001/favourite', movie);
        if (response.status === 201) {
          const updatedFavorites = [...favoriteMovies, movie];
          setFavoriteMovies(updatedFavorites);
          setMovieSections({
            ...movieSections,
            [MovieSection.Favorites]: updatedFavorites,
          });
          addedToFav();
        } else {
          alreadyAddedToFav();
        }
      } catch (error) {
        alreadyAddedToFav();
      }
    }
  };
  
  const handleBack = () => {
    setSelectedMovie(null);
  };

  return (
    <div>
      <ToastContainer />
      <nav className="navbar">
        <ul>
          {Object.values(MovieSection).map((section) => (
            <li
              key={section}
              className={selectedSection === section ? 'active' : ''}
              onClick={() => handleSectionChange(section)}
            >
              {section}
            </li>
          ))}
        </ul>
        <SearchBar
          searchTerm={searchTerm}
          onSearchTermChange={setSearchTerm}
          onSearch={handleSearch}
        />
      </nav>
      <div className="container">
      { !favoriteMovies ? (
        <p>Loading...</p>
      ) : selectedMovie ? (
          <MovieDetails movie={selectedMovie} onBack={handleBack} />
        ) : (
          <MovieList
            movies={isSearchActive ? filteredMovies : selectedMovies}
            favoriteMovies={favoriteMovies}
            onFavorite={handleFavorite}
            onMovieClick={handleMovieClick}
            isSearchActive={isSearchActive}
            selectedSection={selectedSection}
          />
        )}
      </div>
    </div>
  );
};

export default App;

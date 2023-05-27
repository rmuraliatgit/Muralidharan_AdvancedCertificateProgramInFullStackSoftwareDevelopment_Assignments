import React from 'react';
import { Movie } from './Movie';
import { MovieSection } from '../App';
import MovieCard from './MovieCard';
import '../style/MovieList.css';

interface MovieListProps {
  movies: Movie[];
  favoriteMovies: Movie[];
  onFavorite: (movie: Movie) => void;
  onMovieClick: (movie: Movie) => void;
  isSearchActive: boolean;
  selectedSection: MovieSection;
}

const MovieList: React.FC<MovieListProps> = ({
  movies,
  favoriteMovies,
  onFavorite,
  onMovieClick,
  isSearchActive,
  selectedSection,
}) => {
  const handleFavoriteClick = (movie: Movie) => {
    onFavorite(movie);
  };
  const handleMovieClick = (movie: Movie) => {
    onMovieClick(movie);
  };
  if (!movies.length && !isSearchActive) {
    return null;
  }
  console.log("error handled",isSearchActive, movies);
  return (
    <div className="movie-list">
      {(!movies.length) ? (
        <div className="no-data-message">We don't have that movie</div>
      ) : (
        movies.map((movie) => (
          <MovieCard
            key={movie.id}
            movie={movie}
            isFavorite={favoriteMovies.some((favMovie) => favMovie.id === movie.id)}
            onFavorite={handleFavoriteClick}
            onMovieClick={handleMovieClick}
            selectedSection={selectedSection}
          />
        ))
      )}
    </div>
  );
};

export default MovieList;

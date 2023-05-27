
import React from 'react';
import { Movie } from './Movie';
import { MovieSection } from '../App';
interface MovieCardProps {
  movie: Movie;
  isFavorite: boolean;
  onFavorite: (movie: Movie) => void;
  onMovieClick: (movie: Movie) => void;
  selectedSection: MovieSection;
}

const MovieCard: React.FC<MovieCardProps> = ({
  movie,
  isFavorite,
  onFavorite,
  onMovieClick,
  selectedSection,
}) => {
  const handleFavoriteClick = () => {
    onFavorite(movie);
  };

  const handleImageClick = () => {
    onMovieClick(movie);
  };
  const favoriteButtonText = selectedSection === MovieSection.Favorites ? 'Remove from Favorites' : 'Add to Favorites';
  return (
    <div className="movie-card">
      <img src={movie.posterurl} alt={movie.title} onClick={handleImageClick} />
      <h3>{movie.title}</h3>
      <button className="favorite-button" onClick={handleFavoriteClick}>{favoriteButtonText}</button>
    </div>
  );
};
export default MovieCard;

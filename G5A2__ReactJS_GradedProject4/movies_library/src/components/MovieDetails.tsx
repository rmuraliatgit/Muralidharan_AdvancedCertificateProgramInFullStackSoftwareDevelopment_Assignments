import React, { useState } from 'react';
import { Movie } from './Movie';
import '../style/MovieDetails.css';

interface MovieDetailsProps {
  movie: Movie;
  onBack: () => void;
}

const MovieDetails: React.FC<MovieDetailsProps> = ({ movie, onBack }) => {
  const [showImage, setShowImage] = useState(false);

  const handleBackClick = () => {
    onBack();
  };

  const handleImageClick = () => {
    setShowImage(true);
  };

  const handleCloseImageClick = () => {
    setShowImage(false);
  };

  return (
    <div className={showImage ? 'blur' : ''}>
      {showImage && (
        <div className="overlay">
          <img src={movie.posterurl} alt={movie.title} />
          <button onClick={handleCloseImageClick}>X</button>
        </div>
      )}
      <div className="single-movie-details">
        <div className="single-imageContainer">
        <img src={movie.posterurl} alt={movie.title} onClick={handleImageClick} />
        </div>
        <div>
          <h3>{movie.title}</h3>
          <p>Year: {movie.year}</p>
          <p>Genres: {movie.genres.join(', ')}</p>
          <p>Content Rating: {movie.contentRating}</p>
          <p>Duration: {movie.duration}</p>
          <p>Release Date: {movie.releaseDate}</p>
          <p>Storyline: {movie.storyline}</p>
          <p>Actors: {movie.actors.join(', ')}</p>
          <button onClick={handleBackClick}>Back</button>
        </div>
      </div>
    </div>
  );
};

export default MovieDetails;

import React from 'react';

interface SearchBarProps {
  searchTerm: string;
  onSearchTermChange: (searchTerm: string) => void;
  onSearch: () => void;
}

const SearchBar: React.FC<SearchBarProps> = ({ searchTerm, onSearchTermChange }) => {
  const handleSearchTermChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    onSearchTermChange(e.target.value);
  };

  return (
    <div className="search-bar">
      <input placeholder="search" type="text" value={searchTerm} onChange={(e)=>{
        console.log("searchbar called");
        handleSearchTermChange(e)}
       } />
    </div>
  );
};

export default SearchBar;

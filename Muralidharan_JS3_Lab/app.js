async function fetchWeather() {
    const locationInput = document.getElementById('search-input').value;
    const response = await fetch(`https://api.openweathermap.org/data/2.5/weather?q=${locationInput}&units=metric&appid=7e3f21edee540e6110af347b55eb1ab2`);
    const data = await response.json();
    console.log(data)
    document.getElementById('location').innerText = `${data.name}, ${data.sys.country}`;
    // document.getElementById('date').innerText = new Date(data.dt * 1000).toLocaleDateString();
    document.getElementById('date').innerText = new Date(data.dt * 1000).toLocaleDateString('en-US', {
        weekday: 'long',
        day: 'numeric',
        month: 'long',
        year: 'numeric'
      }).replace(',', '');
    // document.getElementById('temperature').innerText = `${data.main.temp}°C, feeling like ${data.main.feels_like}°C`;
    const temperatureElement = document.getElementById('temperature');
    temperatureElement.innerHTML = `${data.main.temp.toFixed(2)}&deg;C<br>`;
    temperatureElement.innerHTML += `feeling like ${data.main.feels_like.toFixed(2)}&deg;C`;

   
}
const searchInput = document.getElementById("search-input");

searchInput.addEventListener("keydown", async function(event) {
  if (event.key === "Enter") {
    // Call your search function here
    const weatherData = await fetchWeather();
  }
});
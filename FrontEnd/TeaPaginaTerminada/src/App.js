import './App.css'
import celular from '../src/celular.png'

function App() {
  return (
    <div className="App">
    <header className="flex items-center h-[10vh] w-[100vw] bg-[#FBFBFB] border-b-2 border-[#5175FD]">
    <svg className="h-[45%] ml-5 md:ml-12" fill="none" viewBox="0 0 128 64" xmlns="http://www.w3.org/2000/svg">
      <path d="M3.5 4.5h36m0 0l-16 27m16-27h30m40 57.5l7-30.5m-93 0L8 58.5h53l29.5-54H122l-5.5 27m-93 0H59m57.5 0H95" stroke="#5175FD" strokeWidth="9" />
    </svg>
    </header>
      <div className="h-[90vh] w-[100vw] bg-[#FBFBFB] flex flex-col justify-end bg-[url('../src/celular.png')] bg-no-repeat bg-cover md:bg-none">
      <div className="h-[90vh] w-[100vw] absolute grid grid-cols-12 justify-center md:justify-start backdrop-blur-[3px] bg-white/20 md:backdrop-blur-none">
        <div className="flex justify-center md:inline md:mt-20 md:ml-20 col-span-12 md:col-span-5 relative md:static">
          <p className="font-semibold mt-6 md:mt-0 text-4xl text-center md:text-start leading-normal absolute md:static md:text-[3.5rem] md:leading-relaxed ">Transmitir<br></br>Entender<br></br>Aclarar</p>
          <p className="font-medium text-base w-max md:max-w-none absolute mt-56 md:static md:text-lg md:mt-8">¡Descargala para android ya!</p> 
           <a href="./Tea_setup.apk" className="flex justify-center md:inline">
            <button className="absolute mt-72 p-4 w-max md:max-w-none md:mt-4 rounded-xl text-xs md:text-base bg-[#5175FD] text-white flex flex-row items-center mix-blend-hard-light hover:bg-[#4363d8]">Descargar para android&nbsp; 
            <svg className="h-6" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
              <path d="M14.975 3.019l.96-1.732a.193.193 0 00-.338-.187l-.97 1.75a6.541 6.541 0 00-5.253 0l-.97-1.75a.193.193 0 00-.34.187l.96 1.732a5.546 5.546 0 00-3.092 4.876h12.137a5.546 5.546 0 00-3.094-4.876zM9.2 5.674a.507.507 0 11.507-.506.507.507 0 01-.507.506zm5.602 0a.507.507 0 11.507-.506.507.507 0 01-.507.506zM5.93 17.171A1.467 1.467 0 007.4 18.64h.973v3a1.36 1.36 0 102.721 0v-3h1.814v3a1.36 1.36 0 102.72 0v-3h.974a1.467 1.467 0 001.468-1.468V8.375H5.93zm-1.867-9.03a1.362 1.362 0 00-1.36 1.361v5.669a1.36 1.36 0 102.72 0V9.502a1.362 1.362 0 00-1.36-1.36zm15.872 0a1.362 1.362 0 00-1.36 1.361v5.669a1.36 1.36 0 102.72 0V9.502a1.362 1.362 0 00-1.36-1.36z" fill="white"/>
            </svg>
            </button>
          </a>
        </div>
        <img className="hidden md:inline max-w-none mt-[10%] h-[70vh] ml-[50%] md:ml-[55%] md:col-span-4" alt="Mobile" src={celular}></img>
        </div>
      <svg fill="none" viewBox="0 0 1728 342" xmlns="http://www.w3.org/2000/svg">
        <path d="M0 17.87l48-7.045c48-7.047 144-20.356 240 0 96 20.355 192 74.377 288 128.399 96 54.021 192 108.043 288 115.089 96 6.263 192-33.666 288-47.758 96-13.31 192 0 288 14.092 96 13.31 192 26.62 240 33.666l48 6.263V342H0V17.87z" fill="#2a56fa" fillRule="evenodd"/>
      </svg>
      </div>
    </div>
  );
}

export default App;

class Navigation extends HTMLElement {
    constructor() {
      super();
    }
  
    connectedCallback() {
      this.innerHTML = `
        <style>
          @import "components/navigation/navigation.css";
        </style>
        <div class="navigation-bar">
            <div class="navigation">
                <button onclick="window.location.href = 'index.html';">HOME</button>
                <button >NEWS</button>
                <button >ABOUT US</button>
                <button >CONTACT</button>
            </div>
            <div class="navigation-symbol">
                <div class="search">
                    <img src = "images/symbols/search.svg" alt="search icon"/>
                </div>
                <div class="social-media">
                    <img 
                      onclick="window.location.href = 'https://www.instagram.com/marc.welz/';" 
                      src = "images/symbols/instagram.svg" alt="instagram icon"/>
                    <img 
                      onclick="window.location.href = 'https://www.youtube.com/channel/UC1MwmQR-o3j5f-mGL7IqMPA';" 
                      src = "images/symbols/youtube.svg" alt="youtube icon"/>
                    <img src = "images/symbols/facebook.svg" alt="facebook icon"/>
                    <img 
                      onclick="window.location.href = 'https://github.com/marcwelz/m152';" 
                      src = "images/symbols/github.svg" alt="github icon"
                    />
                </div>
            </div>
        </div>
      `;
    }
  }
  
  customElements.define('navigation-component', Navigation);
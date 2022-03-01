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
                <button >HOME</button>
                <button >NEWS</button>
                <button >ABOUT US</button>
                <button >CONTACT</button>
            </div>
            <div class="navigation-symbol">
                <div class="search">
                    <img src = "images/symbols/search.svg" alt="search icon"/>
                </div>
                <div class="social-media">
                    <img src = "images/symbols/instagram.svg" alt="instagram icon"/>
                    <img src = "images/symbols/youtube.svg" alt="youtube icon"/>
                    <img src = "images/symbols/facebook.svg" alt="facebook icon"/>
                </div>
            </div>
        </div>
      `;
    }
  }
  
  customElements.define('navigation-component', Navigation);
class Footer extends HTMLElement {
    constructor() {
      super();
    }
  
    connectedCallback() {
      this.innerHTML = `
        <style>
          @import "components/footer/footer.css";
        </style>
        <div class="footer">
            <div class="footer-content">
              <p>About us</p>
              <p onclick="window.location.href = 'index.html';">Home</p>
              <p onclick="window.location.href = 'galery.html';">Galery</p>
              <p onclick="window.location.href = 'transcript.html';">Transkript</p>
              <p onclick="window.location.href = 'functional_galery.html';">Funktionale Galerie</p>
              </div>
            <div class="credits">
              <p>© Welz Marc</p>
            </div>
        </div>
      `;
    }
  }
  
  customElements.define('footer-component', Footer);
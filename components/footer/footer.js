class Footer extends HTMLElement {
    constructor() {
      super();
    }
  
    connectedCallback() {
      this.innerHTML = `
        <div class="footer">
            <div class="footer-content">
              <p>About us</p>
              <p>News</p>
              <p>Home</p>
              <p>Conent</p>
            </div>
            <div class="credits">
              <p>© Welz Marc</p>
            </div>
        </div>
      `;
    }
  }
  
  customElements.define('footer-component', Footer);
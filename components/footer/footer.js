class Footer extends HTMLElement {
    constructor() {
      super();
    }
  
    connectedCallback() {
      this.innerHTML = `
        <div class="footer">
            footer
        </div>
      `;
    }
  }
  
  customElements.define('footer-component', Footer);
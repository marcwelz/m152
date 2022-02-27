class Title extends HTMLElement {
    constructor() {
      super();
    }
  
    connectedCallback() {
      this.innerHTML = `
        <div class="title">
            <img src = "images/IMG_00088.JPG" alt="main image"/>
            <h1>PISTENBULLY</h1>
        </div>
      `;
    }
  }
  
  customElements.define('title-component', Title);
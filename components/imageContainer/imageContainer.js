class ImageContainer extends HTMLElement {
    constructor() {
      super();

      this.attachShadow({ mode: 'open' });

      this.shadowRoot.innerHTML = `
        <style>
          @import "components/imageContainer/imageContainer.css";
        </style>

        <div class="image-container">
            <img class="image-container-img"/>
        </div>
      `;
    }
  
    connectedCallback() {
        const imgsrc = this.getAttribute("imgsrc")

        this.imagesrc = this.shadowRoot.querySelector('img');
        this.imagesrc.setAttribute("src", imgsrc)

    }
  }
  
  window.customElements.define('image-container-component', ImageContainer);
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
            <div class="image-container-text">
              <p></p>
            </div>
        </div>
      `;
    }
  
    connectedCallback() {
        this.imagesrc = this.shadowRoot.querySelector('img');
        this.textparagraph = this.shadowRoot.querySelector("p")

        const imgsrc = this.getAttribute("imgsrc")
        const isOpen = this.getAttribute("open")

        this.textparagraph.innerHTML = imgsrc.replace("images/images/", "");

        if(isOpen) {
          this.imagesrc.classList.remove("image-container-img")
          this.imagesrc.classList.add("image-container-img__open")
        }

        this.imagesrc.setAttribute("src", imgsrc)

    }
  }
  
  window.customElements.define('image-container-component', ImageContainer);
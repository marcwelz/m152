class Content extends HTMLElement {
    constructor() {
      super();
    }
  
    connectedCallback() {
      this.innerHTML = `
        <div class="content-wrapper">
            <div class="content">
              <slot name="content"></slot>
            </div>
        </div>
      `;
    }

  }
  
  customElements.define('content-component', Content);
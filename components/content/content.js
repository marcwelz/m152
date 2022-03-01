class Content extends HTMLElement {
    constructor() {
      super();
      this.attachShadow({ mode: 'open' });
      this.shadowRoot.innerHTML = `
      <style>
          @import "components/content/content.css";
        </style>

        <div class="content-wrapper">
            <div class="content">
              <slot></slot>
            </div>
        </div>
      `;
    }
  }
  
  window.customElements.define('content-component', Content);
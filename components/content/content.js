class Content extends HTMLElement {

    

    constructor() {
      super();
      this.attachShadow({ mode: 'open' });
      this.shadowRoot.innerHTML = `
        <style>
          .content-wrapper {
            width: 100%;
            margin-top: -120px;
            justify-content: center;
            display: flex;
          }
          
          .content {
              width: 80%;
              min-height: 1200px;
              background-color: white;
              
              box-shadow: 0px 1px 8px rgba(0,0,0,0.15);
          }
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
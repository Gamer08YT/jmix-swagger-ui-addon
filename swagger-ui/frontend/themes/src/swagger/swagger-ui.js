import 'jquery/jquery.js'
import {ElementMixin} from '@vaadin/component-base/src/element-mixin.js';
import {ThemableMixin} from '@vaadin/vaadin-themable-mixin/vaadin-themable-mixin.js';
import {defineCustomElement} from '@vaadin/component-base/src/define.js';
import {css, html, LitElement} from 'lit';
import {PolylitMixin} from '@vaadin/component-base/src/polylit-mixin.js';

import SwaggerUI from 'swagger-ui';

//import "swagger-ui-react/swagger-ui.css"

/**
 * The `Swagger` class extends the `ElementMixin` and integrates the Swagger UI into a web component.
 * It enables rendering and managing OpenAPI documentation dynamically via a provided URL.
 */
class Swagger extends ElementMixin(ThemableMixin(PolylitMixin(LitElement))) {


    constructor() {
        super();

        console.log("Swagger UI Constructor.")
    }

    /**
     * Retrieves the identifier for the custom element.
     *
     * @return {string} A string representing the identifier, 'swagger'.
     */
    static get is() {
        return 'swagger-ui';
    };

    static get styles() {
        return css`
            :host {
                display: block;
                width: 100%;
                height: 100%;
            }

            #render-target {
                width: 100%;
                height: 100%;
            }
        `;
    }

    /**
     * Gets the properties of the component.
     *
     * @return {Object} An object representing the defined properties, including details such as their type, default value, and any associated observer methods.
     */
    static get properties() {
        return {
            url: {
                type: String,
                notify: true,
                value: '/rest/docs/internal',
                observer: '_onUrlChange'
            },
            /** @private */
            _domElement: {
                type: Object
            },
            _swagger: {
                type: Object,
            }
        };
    }

    /**
     * Handles the event triggered when the URL changes. Updates or refreshes
     * the OpenAPI documentation view based on the new URL provided.
     *
     * @param {string} valueIO - The new URL or identifier input to update the OpenAPI Documentation.
     * @return {void} This method does not return any value.
     */
    _onUrlChange(valueIO) {
        console.log("Refreshing URL of OpenAPI Documentation.");

        //this.init();
    }

    _onUrlsChange(valueIO) {
        console.log("Refreshing URLs of OpenAPI Documentation.");
    }

    /**
     * Initializes the custom element once it is ready.
     * Calls the parent's ready method, assigns the element to a property,
     * and triggers the initialization logic.
     *
     * @return {void} This method does not return a value.
     */
    /** @protected */
    ready() {
        super.ready();

        console.log("Preparing SwaggerUi UI.");

        // Get DOM Element.
        this._domElement = this.shadowRoot.getElementById('render-target');

        // Add SwaggerUi UI.
        this.init();
    }

    render() {
        return html`
            <div id="render-target"></div>
        `;
    }

    /**
     * Initializes the SwaggerUi UI instance with the provided URL and DOM node.
     * This method sets up the SwaggerUi UI using the `SwaggerUIBundle` by binding it to the specified DOM element and setting the appropriate configuration options.
     *
     * @return {void} This method does not return a value.
     */
    // https://github.com/swagger-api/swagger-ui/blob/HEAD/docs/usage/installation.md#installation
    init() {
        console.log("Initializing Swagger UI for Component");

        try {
            this._swagger = SwaggerUI({
                url: this.url,
                domNode: this._domElement,
                docExpansion: "full"
            });
            console.log('Swagger UI initialized');
        } catch (error) {
            console.error('Failed to initialize Swagger UI:', error);
        }

        console.log(this._swagger);
    }


}

defineCustomElement(Swagger);
export {Swagger};
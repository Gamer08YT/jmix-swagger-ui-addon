import {ElementMixin} from '@vaadin/component-base/src/element-mixin.js';
import {ThemableMixin} from '@vaadin/vaadin-themable-mixin/vaadin-themable-mixin.js';
import {defineCustomElement} from '@vaadin/component-base/src/define.js';
import {css, html, LitElement} from 'lit';
import {PolylitMixin} from '@vaadin/component-base/src/polylit-mixin.js';
// import SwaggerUiStandalonePreset from "swagger-ui/swagger-ui-standalone-preset.js";
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
    // https://github.com/swagger-api/swagger-ui/blob/HEAD/docs/usage/configuration.md
    static get properties() {
        return {
            url: {
                type: String,
                value: '/rest/docs/internal',
                observer: '_onGenericUpdate'
            },
            useUnsafeMarkdown: {
                type: Boolean,
                value: false,
                observer: '_onGenericUpdate'
            },
            syntaxHighlight: {
                type: Boolean,
                value: false,
                observer: '_onGenericUpdate'
            },
            deepLinking: {
                type: Boolean,
                value: false,
                observer: '_onGenericUpdate'
            },
            docExpansion: {
                type: String,
                value: "full",
                observer: '_onGenericUpdate'
            },
            tryItOutEnabled: {
                type: Boolean,
                value: false,
                observer: '_onGenericUpdate'
            },
            requestSnippetsEnabled: {
                type: Boolean,
                value: false,
                observer: '_onGenericUpdate'
            },
            urls: {
                type: String,
                value: [],
                observer: '_onGenericUpdate'
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
     * Handles a generic update event by logging the updated OpenAPI Documentation URL and the provided input.
     *
     * @param {any} valueIO - The input value to be processed and logged.
     * @return {void} This method does not return a value.
     */
    _onGenericUpdate(valueIO) {
        if (this._swagger === undefined) {
            return;
        }

        console.log("Refreshing URL of OpenAPI Documentation.");
        console.log(valueIO);

        // Clear Render Container.
        this._domElement.innerHTML = '';

        // Recreate Swagger UI.
        this.init();
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
            let config = {
                domNode: this._domElement,
                docExpansion: this.docExpansion,
                deepLinking: this.deepLinking,
                tryItOutEnabled: this.tryItOutEnabled,
                requestSnippetsEnabled: this.requestSnippetsEnabled,
                syntaxHighlight: this.syntaxHighlight,
                useUnsafeMarkdown: this.useUnsafeMarkdown,
                // plugins: [SwaggerUiStandalonePreset],
                // layout: "StandaloneLayout",
            }

            // if (this.urls.length > 0) {
            //     config.urls = this.urls.map(url => ({
            //         url: "URL: " + url,
            //         name: url
            //     }));
            //
            //     console.log("Using Swagger URLs Mode.")
            // } else {
                config.url = this.url;
                // config.urls = [{
                //     name: "URL: " + this.url,
                //     url: this.url
                // }];

                console.log("Using Swagger URL Mode.")
            // }

            console.log(config);

            this._swagger = SwaggerUI(config);

            console.log('Swagger UI initialized');
        } catch (error) {
            console.error('Failed to initialize Swagger UI:', error);
        }

        console.log(this._swagger);
    }


}

defineCustomElement(Swagger);
export {Swagger};
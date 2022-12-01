import Keycloak from 'keycloak-js'

const keycloak = new Keycloak({
  url: `http://localhost:8081/auth`,
  realm: 'ProjetAPI',
  clientId: 'frontendReact',
})

export default keycloak
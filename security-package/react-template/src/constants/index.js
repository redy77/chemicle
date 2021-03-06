export const API_AUTHENTICATION_URL = 'http://localhost:8080/authorization-application';
export const API_REGISTRATION_URL = 'http://localhost:8080/registration-application';

export const ACCESS_TOKEN = 'accessToken';

export const OAUTH2_REDIRECT_URI = 'http://localhost:3000/oauth2/redirect'

export const GOOGLE_AUTH_URL = API_AUTHENTICATION_URL + '/oauth2/authorize/google?redirect_uri=' + OAUTH2_REDIRECT_URI;
export const FACEBOOK_AUTH_URL = API_AUTHENTICATION_URL + '/oauth2/authorize/facebook?redirect_uri=' + OAUTH2_REDIRECT_URI;

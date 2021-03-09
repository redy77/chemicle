import React, { Component } from 'react';
import './Login.css';
import { GOOGLE_AUTH_URL, FACEBOOK_AUTH_URL, ACCESS_TOKEN } from '../../constants';
import { login } from '../../util/APIUtils';
import { Link, Redirect } from 'react-router-dom'
import fbLogo from '../../img/fb-logo.png';
import googleLogo from '../../img/google-logo.png';
import Alert from 'react-s-alert';
import Particles from "react-tsparticles";

class Login extends Component {

    componentDidMount() {
        if(this.props.location.state && this.props.location.state.error) {
            setTimeout(() => {
                Alert.error(this.props.location.state.error, {
                    timeout: 5000
                });
                this.props.history.replace({
                    pathname: this.props.location.pathname,
                    state: {}
                });
            }, 100);
        }
    }
    
    render() {
        if(this.props.authenticated) {
            return <Redirect
                to={{
                pathname: "/profile",
                state: { from: this.props.location }
            }}/>;            
        }

        return (
            <div className="login-container">
                <Particles
                    id="tsparticles"
                    init={this.particlesInit}
                    loaded={this.particlesLoaded}
                    options={{
                        fpsLimit: 60,
                        particles: {
                            number: {
                                value: 80,
                                density: {
                                    enable: true,
                                    value_area: 800
                                }
                            },
                            color: {
                                value: ["#2EB67D", "#ECB22E", "#E01E5B", "#36C5F0"]
                            },
                            shape: {
                                type: ["circle"],
                                stroke: {
                                    width: 0,
                                    color: "#fff"
                                },
                                polygon: {
                                    nb_sides: 5
                                },
                            },
                            opacity: {
                                value: 1,
                                random: false,
                                anim: {
                                    enable: false,
                                    speed: 1,
                                    opacity_min: 0.1,
                                    sync: false
                                }
                            },
                            size: {
                                value: 8,
                                random: true,
                                anim: {
                                    enable: false,
                                    speed: 10,
                                    size_min: 10,
                                    sync: false
                                }
                            },
                            line_linked: {
                                enable: true,
                                distance: 150,
                                color: "#808080",
                                opacity: 0.4,
                                width: 1
                            },
                            move: {
                                enable: true,
                                speed: 5,
                                direction: "none",
                                random: false,
                                straight: false,
                                out_mode: "out",
                                bounce: false,
                                attract: {
                                    enable: false,
                                    rotateX: 600,
                                    rotateY: 1200
                                }
                            }
                        },
                        interactivity: {
                            detect_on: "canvas",
                            events: {
                                onhover: {
                                    enable: true,
                                    mode: "grab"
                                },
                                onclick: {
                                    enable: true,
                                    mode: "push"
                                },
                                resize: true
                            },
                            modes: {
                                grab: {
                                    distance: 140,
                                    line_linked: {
                                        opacity: 1
                                    }
                                },
                                bubble: {
                                    distance: 400,
                                    size: 40,
                                    duration: 2,
                                    opacity: 8,
                                    speed: 3
                                },
                                repulse: {
                                    distance: 200,
                                    duration: 0.4
                                },
                                push: {
                                    particles_nb: 4
                                },
                                remove: {
                                    particles_nb: 2
                                }
                            }
                        },
                        retina_detect: true,
                    }}/>
                <div className="login-content">
                    <h1 className="login-title">Войдите через соцсети:</h1>
                    <SocialLogin />
                    <div className="or-separator">
                        <span className="or-text">ИЛИ</span>
                    </div>
                    <LoginForm {...this.props} />
                    <span className="signup-link">Новый пользователь? <Link to="/signup">Зарегистрируйтесь!</Link></span>
                </div>
            </div>
        );
    }
}

class SocialLogin extends Component {
    render() {
        return (
            <div className="social-login">
                <a className="btn btn-block social-btn google" href={GOOGLE_AUTH_URL}>
                    <img src={googleLogo} alt="Google" /> Войти через Google</a>
                <a className="btn btn-block social-btn facebook" href={FACEBOOK_AUTH_URL}>
                    <img src={fbLogo} alt="Facebook" /> Войти через Facebook</a>
            </div>
        );
    }
}

class LoginForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            email: '',
            password: ''
        };
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleInputChange(event) {
        const target = event.target;
        const inputName = target.name;        
        const inputValue = target.value;

        this.setState({
            [inputName] : inputValue
        });        
    }

    handleSubmit(event) {
        event.preventDefault();   

        const loginRequest = Object.assign({}, this.state);

        login(loginRequest)
        .then(response => {
            localStorage.setItem(ACCESS_TOKEN, response.accessToken);
            Alert.success("Вы успешно авторизовались!");
            this.props.history.push("/");
        }).catch(error => {
            Alert.error((error && error.message) || 'Что то пошло не так! Попробуйте еще раз!');
        });
    }
    
    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <div className="form-item">
                    <input type="email" name="email" 
                        className="form-control" placeholder="Email"
                        value={this.state.email} onChange={this.handleInputChange} required/>
                </div>
                <div className="form-item">
                    <input type="password" name="password" 
                        className="form-control" placeholder="Пароль"
                        value={this.state.password} onChange={this.handleInputChange} required/>
                </div>
                <div className="form-item">
                    <button type="submit" className="btn btn-block btn-primary">Войти</button>
                </div>
            </form>                    
        );
    }
}

export default Login

import React, {Component} from 'react';
import './Signup.css';
import {Link, Redirect} from 'react-router-dom'
import {GOOGLE_AUTH_URL, FACEBOOK_AUTH_URL} from '../../constants';
import {signup} from '../../util/APIUtils';
import fbLogo from '../../img/fb-logo.png';
import googleLogo from '../../img/google-logo.png';
import Alert from 'react-s-alert';

class Signup extends Component {
    render() {
        if (this.props.authenticated) {
            return <Redirect
                to={{
                    pathname: "/",
                    state: {from: this.props.location}
                }}/>;
        }

        return (

            <div className="signup-container">
                <div className="signup-content">
                    <h1 className="signup-title">Регистрация:</h1>
                    <SignupForm {...this.props} />
                    <span className="login-link">Уже зарегистрированы? <Link to="/login">Войдите!</Link></span>
                </div>
            </div>
        );
    }
}


class SocialSignup extends Component {
    render() {
        return (
            <div className="social-signup">
                <a className="btn btn-block social-btn google" href={GOOGLE_AUTH_URL}>
                    <img src={googleLogo} alt="Google"/> Регистрация через Google</a>
                <a className="btn btn-block social-btn facebook" href={FACEBOOK_AUTH_URL}>
                    <img src={fbLogo} alt="Facebook"/> Регистрация через Facebook</a>
            </div>
        );
    }
}

class SignupForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: '',
            surname: '',
            birthday: '',
            gender: '',
            phone: '',
            email: '',
            password: ''
        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleInputChange(event) {
        const target = event.target;
        const inputName = target.name;
        const inputValue = target.value;

        this.setState({
            [inputName]: inputValue
        });
    }

    handleSubmit(event) {
        event.preventDefault();

        const signUpRequest = Object.assign({}, this.state);

        signup(signUpRequest)
            .then(response => {
                Alert.success("Регистрация прошла успешно. Войдите для продолжения!");
                this.props.history.push("/login");
            }).catch(error => {
            Alert.error((error && error.message) || 'Что то пошло не так! Попробуйте еще раз!');
        });
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <div className="form-item">
                    <input type="text" name="name"
                           className="form-control" placeholder="Имя"
                           value={this.state.name} onChange={this.handleInputChange} required/>
                </div>
                <div className="form-item">
                    <input type="text" name="surname"
                           className="form-control" placeholder="Фамилия"
                           value={this.state.surname} onChange={this.handleInputChange} required/>
                </div>
                <div className="form-item" align="left">
                    <p>Дата рождения:&nbsp;&nbsp;&nbsp;
                        <input type="date" name="birthday"
                               value={this.state.birthday}
                               min="1970-01-01" max="2010-12-31"
                               onChange={this.handleInputChange}/></p>
                </div>
                <div className="form-item" align="left">
                    <div onChange={this.handleInputChange}>
                        <p>Пол: &emsp;&emsp;&emsp;&emsp;&emsp;&nbsp;
                            <input type="radio" value="MALE" name="gender"/> Мужской
                            <input type="radio" value="FEMALE" name="gender"/> Женский</p>
                    </div>
                </div>
                <div className="form-item">
                    <input type="number" pattern="[0-9]*" name="phone"
                           className="form-control" placeholder="Номер телефона"
                           value={this.state.phone} onChange={this.handleInputChange} required/>
                </div>
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
                    <button type="submit" className="btn btn-block btn-primary">Зарегистрироваться</button>
                </div>
            </form>

        );
    }
}

export default Signup
import React, { Component } from 'react';
import { Link, NavLink } from 'react-router-dom';
import './AppHeader.css';

class AppHeader extends Component {


    render() {
        return (
            <header className="app-header">
                <div className="container">
                    <div className="app-branding">
                        <Link to="/" className="app-title">Портал Chemcool</Link>
                    </div>
                    <div className="app-options">
                        <nav className="app-nav">
                                { this.props.authenticated ? (
                                    <ul>
                                        <li>
                                            <NavLink to="/profile">Профиль</NavLink>
                                        </li>
                                        <li>
                                            <a onClick={this.props.onLogout}>Выйти</a>
                                        </li>
                                    </ul>
                                ): (
                                    <ul>
                                        <li>

                                            <Link to="/login">
                                                <div className="first"><button data-backcolor="#5cb85c" className="btn btn-success">
                                                    Вход
                                                </button></div>
                                            </Link>

                                        </li>
                                        <li>
                                            <Link to="/signup">
                                                <div className="first"><button data-backcolor="#428bca" className="btn btn-primary">
                                                    Регистрация
                                                </button></div>
                                            </Link>
                                        </li>
                                    </ul>
                                )}
                        </nav>
                    </div>
                </div>
            </header>
        )
    }
}

export default AppHeader;
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import {PrivateRoutes} from './PrivateRoutes';
import {Home, Login, Profile, Account} from '../pages/Index';

export function AppRoutes() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path = '/' element = {<Home />}/>
                <Route path = '*' element = {<h1>404: Não encontrado!</h1>} />
                <Route path = '/login' element = {<Login />} />
                <Route element = {<PrivateRoutes isAuthenticated = {false}/>}>
                    <Route path = '/profile' element = {<Profile />}/>
                    <Route path = '/account' element = {<Account />}/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
}
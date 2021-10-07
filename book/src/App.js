import { Component } from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import "./App.css";
import CSSBook from "./book/cssBook";
import HTMLBook from "./book/htmlBook";
import JavascriptBook from "./book/javascriptBook";
import CSS from "./pages/css";
import HTML from "./pages/html";
import Javascript from "./pages/javascript";
class App extends Component {
  render() {
    return (
      <div>
        <BrowserRouter>
          <Switch>
            <Route path="/" component={HTML} exact />
            <Route path="/html/book" component={HTML} exact />
            <Route path="/css/book" component={CSS} exact />
            <Route path="/javascript/book" component={Javascript} exact />
            <Route path="/html/book/:id" component={HTMLBook} exact />
            <Route path="/css/book/:id" component={CSSBook} exact />
            <Route
              path="/javascript/book/:id"
              component={JavascriptBook}
              exact
            />
          </Switch>
        </BrowserRouter>
      </div>
    );
  }
}

export default App;

import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import Blog from "./Blog";
import Details from "./Details";
function App() {
  return (
    <div>
      <h1>React Application</h1>
      <Router>
        <Link to="/blog">Go to Blog</Link>
        <Route path="/blog">
          <Blog />
        </Route>
        <Route
          path="/details/:id"
          render={(props) => <Details {...props} />}
        ></Route>
      </Router>
    </div>
  );
}

export default App;

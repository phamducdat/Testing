import {
  Avatar,
  Card,
  CardActionArea,
  CardActions,
  CardContent,
  CardMedia,
  Container,
  Grid,
} from "@material-ui/core";
import AppBar from "@material-ui/core/AppBar";
import { makeStyles } from "@material-ui/core/styles";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import BookmarkBorderIcon from "@material-ui/icons/BookmarkBorder";
import { Box } from "@mui/system";
import React from "react";
import "./App.css";

const useStyle = makeStyles((theme) => ({
  appBar: {
    backgroundColor: "#fff",
  },
  hero: {
    backgroundImage: `linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url('https://images.unsplash.com/photo-1558981852-426c6c22a060?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80')`,

    height: "500px",
    backgroundPosition: "center",
    backgroundRepeat: "no-repeat",
    backgroundSize: "cover",
    position: "relative",
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    color: "#fff",
    fontSize: "4rem",
  },

  blogsContainer: {
    paddingBottom: theme.spacing(3),
  },
  blogTitle: {
    fontWeight: 800,
    paddingBottom: theme.spacing(3),
  },
  card: {
    maxWidth: 345,
  },
  media: {
    height: 140,
  },
  cardActions: {
    display: "flex",
    margin: "0 10px",
    justifyContent: "space-between",
  },
}));

function App() {
  const classes = useStyle();

  return (
    <div className="App">
      <AppBar className={classes.appBar} position="static">
        <Toolbar>
          <Typography variant="h6" color="primary">
            Blog
          </Typography>
        </Toolbar>
      </AppBar>
      <Box className={classes.hero}>
        <Box>React Blog</Box>
      </Box>
      <Container maxWidth="lg" className={classes.blogsContainer}>
        <Typography variant="h4" className={classes.blogTitle}>
          Articles
        </Typography>
        <Grid container spacing={3}>
          <Grid item xs={12} sm={6} md={4}></Grid>
          <Card className={classes.card}>
            <CardActionArea>
              <CardMedia
                className={classes.media}
                image="https://images.pexels.com/photos/2004161/pexels-photo-2004161.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                title="Contemplative Reptile"
              />
              <CardContent>
                <Typography gutterBottom variant="h5" component="h2">
                  React useContext
                </Typography>
                <Typography variant="body2" color="textSecondary" component="p">
                  Lizards are a widespread group of squamate reptiles, with over
                  6,000 species, ranging across all continents except Antarctica
                </Typography>
              </CardContent>
            </CardActionArea>
            <CardActions className={classes.cardActions}>
              <Box className={classes.author}>
                <Avatar src="https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260" />
                <Box ml={2}>
                  <Typography variant="subtitle2" component="p">
                    Guy Clemons
                  </Typography>
                  <Typography
                    variant="subtitle2"
                    color="textSecondary"
                    component="p"
                  >
                    May 14, 2020
                  </Typography>
                </Box>
              </Box>
              <Box>
                <BookmarkBorderIcon />
              </Box>
            </CardActions>
          </Card>
          <Grid item xs={12} sm={6} md={4}></Grid>
          <Grid item xs={12} sm={6} md={4}></Grid>
        </Grid>
      </Container>
    </div>
  );
}

export default App;

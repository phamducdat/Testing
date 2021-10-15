import React from "react";
import data from "./data";
import Card from "./Card";
const Blog = () => {
  return (
    <section className="py-4 py-lg-5 container">
      <div className="row justify-content-center">
        {data.cardData.map((item, index) => {
          return (
            <Card
              key={index}
              img={item.img}
              tile={item.title}
              link={`/details/${item.id}`}
            />
          );
        })}
      </div>
    </section>
  );
};

export default Blog;

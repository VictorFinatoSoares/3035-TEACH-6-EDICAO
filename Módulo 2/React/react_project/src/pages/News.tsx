import React from "react";
import { Card } from "../components/Card";

export function News() {
  const news = [
    {
      id: 1,
      title: "Titulo 1",
      content: "Lorem ipsum",
    },
    {
      id: 2,
      title: "Titulo 2",
      content: "Morel pusim",
    },
    {
      id: 3,
      title: "Titulo 3",
      content: "Lorem musip",
    },
  ];

  return (
    <div>
      <h1 className="text-3xl font-bold underline mb-6">Notícias</h1>
      <div className="flex gap-4">
        {news.map((item) => (
          <Card title={item.title} content={item.content} />
        ))}
      </div>
    </div>
  );
}

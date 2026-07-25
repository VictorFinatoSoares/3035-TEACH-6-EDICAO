import React from "react";

type Props = {
  title: string;
  content: string;
};

export function Card({ title, content }: Props) {
  return (
    <div className="ml-1 p-4 bg-red-500 rounded-md shadow-md w-64">
      <h2 className="font-bold">{title}</h2>
      <p>{content}</p>
    </div>
  );
}

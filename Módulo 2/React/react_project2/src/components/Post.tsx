interface Props {
  id: number;
  title: string;
  body: string;
}

export function Post({ id, title, body }: Props) {
  return (
    <div className="border border-gray-300 rounded-md p-4 cursor-pointer hover:shadow-md">
      <h1 className="font-bold text-xl">
        {id}. {title}
      </h1>
      <p className="font-light text-gray-500">{body}</p>
    </div>
  );
}

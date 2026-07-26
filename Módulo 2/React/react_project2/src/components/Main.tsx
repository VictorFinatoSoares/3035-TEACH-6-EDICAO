import { PostsList } from "./PostsList";

export function Main() {
  return (
    <main className="mx-56 my-4">
      <header>
        <h1 className="font-bold text-3xl">Blog React</h1>
        <hr className="my-4" />
      </header>
      <PostsList />
    </main>
  );
}

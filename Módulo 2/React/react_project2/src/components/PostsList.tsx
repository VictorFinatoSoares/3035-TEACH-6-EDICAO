import { Post } from "./Post";

export function PostsList() {
  return (
    <ul className="py-6 flex flex-col gap-3">
      <li>
        <Post />
      </li>
      <li>
        <Post />
      </li>
      <li>
        <Post />
      </li>
    </ul>
  );
}

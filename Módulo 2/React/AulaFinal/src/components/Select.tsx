interface Props {
  options: string[];
  onChange: (event: React.ChangeEvent<HTMLSelectElement>) => void;
}

export function Select({ options, onChange }: Props) {
  return (
    <select name="season" onChange={onChange}>
      {options.map((item) => (
        <option value={item} key={item}>
          {item}
        </option>
      ))}
    </select>
  );
}

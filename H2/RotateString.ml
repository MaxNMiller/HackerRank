let rec all s =
  let len = String.length s in
  let rec build n s =
    if n = 0 then []
    else
      let s' = String.sub s 1 (len - 1) ^ String.sub s 0 1 in
      s' :: build (n - 1) s'
  in
  build len s

let () =
  let rec process_lines lines =
    match lines with
    | [] -> ()
    | line :: rest ->
      let rotations = all line in
      let rotated_str = String.concat " " rotations in
      print_endline rotated_str;
      process_lines rest
  in
  let rec read_lines n acc =
    if n = 0 then List.rev acc
    else
      let line = input_line stdin in
      read_lines (n - 1) (line :: acc)
  in
  let num_lines = int_of_string (input_line stdin) in
  let lines = read_lines num_lines [] in
  process_lines lines

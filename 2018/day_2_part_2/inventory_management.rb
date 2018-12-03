def compute(input = File.readlines('./input.txt'))
  results = []
  input.each do |line|
    input.each do |second_line|
      mismatching_character_count = 0
      second_line_characters = second_line.strip.chars
      line.strip.chars.each_with_index do |character, index|
        if character != second_line_characters[index]
          mismatching_character_count += 1
          if mismatching_character_count > 1
            break
          end
        end
      end

      if mismatching_character_count == 1
        if !results.include? [second_line.strip, line.strip]
          results.append [line.strip, second_line.strip]
        end
      end
    end
  end

  results
end


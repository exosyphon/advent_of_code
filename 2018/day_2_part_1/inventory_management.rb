def compute(input = File.readlines('./input.txt'))
  two_character_counts = 0
  three_character_counts = 0
  input.each do |line|
    duplicate_characters = Array.new(26, 0)
    line.strip.chars.each do |character|
      duplicate_characters[character.ord - 97] += 1    
    end

    two_character_counts += duplicate_characters.any? {|char_count| char_count == 2} ? 1 : 0
    three_character_counts += duplicate_characters.any? {|char_count| char_count == 3} ? 1 : 0
  end

  two_character_counts * three_character_counts
end


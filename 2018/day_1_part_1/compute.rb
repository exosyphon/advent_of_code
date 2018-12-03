total = 0

File.open('./input.txt').each_line do |line|
  total += line.to_i
end

puts total

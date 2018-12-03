class Compute 
  def compute(input = File.readlines('./input.txt')) 
    frequency_counts = {}
    frequency_counts[0] = 1
    frequency = 0
    while true do
      input.each do |line|
        frequency += line.to_i

        if frequency_counts[frequency].nil? 
          frequency_counts[frequency] = 0
        else 
          return frequency
        end

        frequency_counts[frequency] += 1
      end
    end
  end
end

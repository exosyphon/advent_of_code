require 'rspec'
require './inventory_management.rb'

describe 'compute' do
  it 'should return checksums for lists of box Ids' do
    expect(compute(['abcdef'])).to eq 0
    expect(compute(['abcdef', 'bababc'])).to eq 1
    expect(compute(['abcdef', 'bababc', 'abbcde'])).to eq 2
    expect(compute(['abcdef', 'bababc', 'abbcde', 'abcccd'])).to eq 4
    expect(compute(['abcdef', 'bababc', 'abbcde', 'abcccd', 'aabcdd'])).to eq 6
    expect(compute(['abcdef', 'bababc', 'abbcde', 'abcccd', 'aabcdd', 'abcdee'])).to eq 8
    expect(compute(['abcdef', 'bababc', 'abbcde', 'abcccd', 'aabcdd', 'abcdee', 'ababab'])).to eq 12
  end

  it 'should return 7657 for file input' do
    expect(compute()).to eq 7657
  end
end

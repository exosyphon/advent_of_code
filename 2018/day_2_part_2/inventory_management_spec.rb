require 'rspec'
require './inventory_management.rb'

describe 'compute' do
  it 'should return list of IDs that have only 1 character difference' do
    expect(compute([
      'abcde',
      'fghij',
      'klmno',
      'pqrst',
      'fguij',
      'axcye',
      'wvxyz'
      ])).to eq [["fghij", "fguij"]]
  end

  it 'should return [["ivjhcadokexltwgsfsmqwrbnuy", "ivjhcadokesltwgsfsmqwrbnuy"]] for file input' do
    expect(compute()).to eq [["ivjhcadokexltwgsfsmqwrbnuy", "ivjhcadokesltwgsfsmqwrbnuy"]]
  end
end

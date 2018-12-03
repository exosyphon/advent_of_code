require 'rspec'
require './compute.rb'

describe 'compute' do
  it 'should return first time frequency count occurs twice' do
    expect(Compute.new.compute(['+1', '-1'])).to eq 0
    expect(Compute.new.compute(['+3', '+3', '+4', '-2', '-4'])).to eq 10
    expect(Compute.new.compute(['-6', '+3', '+8', '+5', '-6'])).to eq 5
    expect(Compute.new.compute(['+7', '+7', '-2', '-7', '-4'])).to eq 14
  end

  it 'should return 65474 when using the file input' do
    expect(Compute.new.compute()).to eq 65474
  end
end

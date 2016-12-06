#! /usr/bin/env python

def map(line):
	new_dict = {}
	array_word = line.split()
	for word in array_word:
		if new_dict.get(word) is None:
			new_dict[word] = 1
		else:
			new_dict[word] = new_dict[word] + 1
		#endif
	#endfor
	return new_dict
#enddef


def reduce(tmp_dict):
	for word, value in tmp_dict.iteritems():
		if result_dict.get(word) is None:
			result_dict[word] = value
		else:
			result_dict[word] = result_dict[word] + value
		#endif
	#endfor
#enddef


result_dict = {}
file = open('../resources/text_for_word_count.txt', 'r')
for line in file:
	tmp_dict = map(line)
	reduce(tmp_dict)
#endfor

for word, count in result_dict.iteritems():
	print str(count) + ' ' + word
#endfor

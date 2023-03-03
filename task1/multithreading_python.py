import threading


# Function to reverse a string
def reverse_string(string):
    return string[::-1]


# Function to reverse each string in the paragraph
def reverse_paragraph(paragraph):
    words = paragraph.split()
    results = []

    # Create a thread for each word in the paragraph
    threads = [threading.Thread(target=lambda result, word: result.append(reverse_string(word)), args=(results, word))
               for word in words]

    # Start each thread
    for thread in threads:
        thread.start()

    # Wait for each thread to complete
    for thread in threads:
        thread.join()

    # Join the reversed words back into a paragraph
    return ' '.join(results)


# Example usage
paragraph = input("enter:")
reversed_paragraph = reverse_paragraph(paragraph)
print(reversed_paragraph)

teacher = {'name':'ashley', 'job':'instructor', 'topic':'python'}

def printer(name, job, topic):
    print(name)
    print(job)
    print(topic)

printer(**teacher)
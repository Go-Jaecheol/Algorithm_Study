def solution(genres, plays):
    answer = []
    album = {}
    for i, genre in enumerate(genres):
        if genre in album:
            album[genre]["music"][i] = plays[i]
            album[genre]["play"] += plays[i]
        else:
            album[genre] = {"music": {i: plays[i]}, "play": plays[i]}
    
    for item in sorted(album.items(), key=lambda x: -x[1]["play"]):
        num = sorted(item[1]["music"].items(), key=lambda x: (-x[1], x[0]))
        answer.append(num[0][0])
        if len(num) > 1:
            answer.append(num[1][0])
    
    return answer
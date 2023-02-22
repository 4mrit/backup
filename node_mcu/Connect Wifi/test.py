import praw
import gtts
import moviepy.editor as mp
from google.oauth2.credentials import Credentials
from googleapiclient.errors import HttpError
from googleapiclient.discovery import build

# Authenticate with the YouTube API
creds = Credentials.from_authorized_user_info(info=info)
youtube = build('youtube', 'v3', credentials=creds)

# Access the subreddit and retrieve a random story
reddit = praw.Reddit(client_id=client_id, client_secret=client_secret, user_agent=user_agent)
subreddit = reddit.subreddit('random')
story = subreddit.random()

# Generate a narrated audio version of the story
audio = gtts.gTTS(text=story.title)
audio.save('story.mp3')

# Create a video file with the narrated audio
clip = mp.AudioFileClip('story.mp3')
clip.write_videofile('story.mp4')

# Upload the video to YouTube Shorts
request = youtube.videos().insert(
    part="snippet",
    body={
        "snippet": {
            "categoryId": "22",
            "description": story.title,
            "title": story.title
        },
        "status": {
            "privacyStatus": "public"
        }
    },
    media_body=('story.mp4')
)
response = request.execute()
print(f'Video uploaded to YouTube with ID: {response["id"]}')

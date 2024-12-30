package io.github.roopan.rc.subreddit;

import java.util.List;

public interface SubredditService 
{
	SubredditDTO save(SubredditDTO subredditDTO);
	
	List<Subreddit> getAllSubreddits();
}

package eg.net.lanNansahom.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import eg.net.lanNansahom.business.VictimBusiness;
import eg.net.lanNansahom.dao.InjuredDao;
import eg.net.lanNansahom.dao.MartyrDao;
import eg.net.lanNansahom.datamodel.Article;
import eg.net.lanNansahom.datamodel.Image;
import eg.net.lanNansahom.datamodel.Injured;
import eg.net.lanNansahom.datamodel.Martyr;
import eg.net.lanNansahom.datamodel.Relative;
import eg.net.lanNansahom.datamodel.SearchVictimsCriteria;
import eg.net.lanNansahom.datamodel.Video;
import eg.net.lanNansahom.services.beans.ImageCategry;
import eg.net.lanNansahom.services.beans.Victim;
import eg.net.lanNansahom.services.beans.VictimInfo;
import eg.net.services.BeansMapper;
import eg.net.services.ServiceException;

public class VictimBusinessImpl implements VictimBusiness {

	@Autowired
	private MartyrDao martyrDao;

	@Autowired
	private InjuredDao injuredDao;

	public void addVictim(Victim victim) throws ServiceException {
		if (victim.isMartyr()) {
			Martyr martyr = BeansMapper.map(victim, Martyr.class);
			martyr.setRelatives(BeansMapper.map(victim.getRelatives(), Relative.class));
			martyr.setImages(BeansMapper.map(victim.getImages(), Image.class));
			martyr.setVideos(BeansMapper.map(victim.getVideos(), Video.class));
			martyr.setArticles(BeansMapper.map(victim.getArticles(), Article.class));
			martyrDao.addMartyr(martyr);
		} else {
			Injured injured = BeansMapper.map(victim, Injured.class);
			injured.setRelatives(BeansMapper.map(victim.getRelatives(), Relative.class));
			injured.setImages(BeansMapper.map(victim.getImages(), Image.class));
			injured.setVideos(BeansMapper.map(victim.getVideos(), Video.class));
			injured.setArticles(BeansMapper.map(victim.getArticles(), Article.class));
			injuredDao.addInjured(injured);
		}

	}

	public void updateVictim(Victim victim) throws ServiceException {
		if (victim.isMartyr()) {
			Martyr martyr = martyrDao.getMartyrById(victim.getId());
			List<Relative> relatives = prepareRelatives(victim.getRelatives(), martyr.getRelatives());
			List<Image> images = prepareImages(victim.getImages(), martyr.getImages());
			List<Video> videos = prepareVideos(victim.getVideos(), martyr.getVideos());
			List<Article> articles = prepareArticles(victim.getArticles(), martyr.getArticles());
			martyr = BeansMapper.map(victim, martyr, Martyr.class);
			martyr.setRelatives(relatives);
			martyr.setImages(images);
			martyr.setVideos(videos);
			martyr.setArticles(articles);
			martyrDao.updateMartyr(martyr);
		} else {
			Injured injured = injuredDao.getInjuredById(victim.getId());
			List<Relative> relatives = prepareRelatives(victim.getRelatives(), injured.getRelatives());
			List<Image> images = prepareImages(victim.getImages(), injured.getImages());
			List<Video> videos = prepareVideos(victim.getVideos(), injured.getVideos());
			List<Article> articles = prepareArticles(victim.getArticles(), injured.getArticles());
			injured = BeansMapper.map(victim, injured, Injured.class);
			injured.setRelatives(relatives);
			injured.setImages(images);
			injured.setVideos(videos);
			injured.setArticles(articles);
			injuredDao.updateInjured(injured);
		}

	}

	public void deleteVictims(Victim victim) throws ServiceException {
		if (victim.isMartyr()) {
			Martyr martyr = martyrDao.getMartyrById(victim.getId());
			martyrDao.deleteMartyr(martyr);
		} else {
			Injured injured = injuredDao.getInjuredById(victim.getId());
			injuredDao.deleteInjured(injured);
		}

	}

	public List<Victim> searchVictim(SearchVictimsCriteria criteria) throws ServiceException {
		List<Victim> result = new ArrayList<Victim>();
		result = new ArrayList<Victim>();
		if (criteria.isMartyr()) {
			List<Martyr> martyrs = martyrDao.searchMartyr(criteria);
			for (int i = 0; i < martyrs.size(); i++) {
				result.add(mapVictim(martyrs.get(i)));
			}
		} else {
			List<Injured> injuries = injuredDao.searchInjured(criteria);
			for (int i = 0; i < injuries.size(); i++) {
				result.add(mapVictim(injuries.get(i)));
			}
		}
		return result;
	}

	public List<VictimInfo> searchVictimInfo(SearchVictimsCriteria criteria) throws ServiceException {
		List<VictimInfo> result = new ArrayList<VictimInfo>();
		if (criteria.isMartyr()) {
			List<Martyr> martyrs = martyrDao.searchMartyr(criteria);
			result = BeansMapper.map(martyrs, VictimInfo.class);
			for (int i = 0; i < martyrs.size(); i++) {
				Image image = martyrs.get(i).getImageByType(ImageCategry.Thumbnail);
				if (image != null) {
					result.get(i).setProfileThumbnail(
							BeansMapper.map(image, eg.net.lanNansahom.services.beans.Image.class));
				}

			}
		} else {
			List<Injured> injuries = injuredDao.searchInjured(criteria);
			result = BeansMapper.map(injuries, VictimInfo.class);
			for (int i = 0; i < injuries.size(); i++) {
				Image image = injuries.get(i).getImageByType(ImageCategry.Thumbnail);
				if (image != null) {
					result.get(i).setProfileThumbnail(
							BeansMapper.map(image, eg.net.lanNansahom.services.beans.Image.class));
				}
			}
		}
		return result;
	}

	private List<Relative> prepareRelatives(List<eg.net.lanNansahom.services.beans.Relative> modified,
			List<Relative> original) {
		List<Relative> result = new ArrayList<Relative>();
		for (int i = 0; i < modified.size(); i++) {
			if (modified.get(i).getId() == 0) {
				result.add(BeansMapper.map(modified.get(i), Relative.class));
			} else {
				for (int j = 0; j < original.size(); j++) {
					if (modified.get(i).getId() == original.get(j).getId()) {
						result.add(BeansMapper.map(modified.get(i), original.get(j), Relative.class));
					}
				}
			}
		}
		return result;
	}

	private List<Image> prepareImages(List<eg.net.lanNansahom.services.beans.Image> modified, List<Image> original) {
		List<Image> result = new ArrayList<Image>();
		for (int i = 0; i < modified.size(); i++) {
			if (modified.get(i).getId() == 0) {
				result.add(BeansMapper.map(modified.get(i), Image.class));
			} else {
				for (int j = 0; j < original.size(); j++) {
					if (modified.get(i).getId() == original.get(j).getId()) {
						result.add(BeansMapper.map(modified.get(i), original.get(j), Image.class));
					}
				}
			}
		}
		return result;
	}

	private List<Video> prepareVideos(List<eg.net.lanNansahom.services.beans.Video> modified, List<Video> original) {
		List<Video> result = new ArrayList<Video>();
		for (int i = 0; i < modified.size(); i++) {
			if (modified.get(i).getId() == 0) {
				result.add(BeansMapper.map(modified.get(i), Video.class));
			} else {
				for (int j = 0; j < original.size(); j++) {
					if (modified.get(i).getId() == original.get(j).getId()) {
						result.add(BeansMapper.map(modified.get(i), original.get(j), Video.class));
					}
				}
			}
		}
		return result;
	}

	private List<Article> prepareArticles(List<eg.net.lanNansahom.services.beans.Article> modified,
			List<Article> original) {
		List<Article> result = new ArrayList<Article>();
		for (int i = 0; i < modified.size(); i++) {
			if (modified.get(i).getId() == 0) {
				result.add(BeansMapper.map(modified.get(i), Article.class));
			} else {
				for (int j = 0; j < original.size(); j++) {
					if (modified.get(i).getId() == original.get(j).getId()) {
						result.add(BeansMapper.map(modified.get(i), original.get(j), Article.class));
					}
				}
			}
		}
		return result;
	}

	public Victim getVictimById(int pId) throws ServiceException {
		Victim result = null;
		Martyr martyr = martyrDao.getMartyrById(pId);
		if (martyr != null) {
			result = mapVictim(martyr);
		} else {
			Injured injured = injuredDao.getInjuredById(pId);
			result = mapVictim(injured);
		}
		return result;
	}

	private Victim mapVictim(eg.net.lanNansahom.datamodel.Victim pVictim) {
		Victim result = null;
		if (pVictim != null) {
			result = BeansMapper.map(pVictim, Victim.class);
			result.setRelatives(BeansMapper.map(pVictim.getRelatives(),
					eg.net.lanNansahom.services.beans.Relative.class));
			result.setImages(BeansMapper.map(pVictim.getImages(), eg.net.lanNansahom.services.beans.Image.class));
			result.setVideos(BeansMapper.map(pVictim.getVideos(), eg.net.lanNansahom.services.beans.Video.class));
			result.setArticles(BeansMapper.map(pVictim.getArticles(), eg.net.lanNansahom.services.beans.Article.class));
		}
		return result;
	}

}

# KBO 기록실 (진행중)

**KBO 기록실**은 KBO 리그의 선수별 상세 통계와 경기 관련 정보를 자동으로 수집하고 제공하는 웹 애플리케이션입니다. Spring과 React를 기반으로 개발되었으며, 크롤링 및 다양한 API를 통해 최신 데이터를 사용자에게 제공합니다.

## 기술 스택

| **Backend**     | **Frontend**    | **Data Handling** | **APIs**           |
|-----------------|-----------------|-------------------|--------------------|
| ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white) | ![React](https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=react&logoColor=white) | ![Axios](https://img.shields.io/badge/Axios-5A29E4?style=for-the-badge&logo=axios&logoColor=white)  | ![Weather API](https://img.shields.io/badge/Weather%20API-00897B?style=for-the-badge&logo=weather&logoColor=white) |
| ![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)     | ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white) | ![Web Crawling](https://img.shields.io/badge/Web%20Crawling-4285F4?style=for-the-badge&logo=web-crawling&logoColor=white) | ![Naver News API](https://img.shields.io/badge/Naver%20News%20API-03C75A?style=for-the-badge&logo=naver&logoColor=white) |


## 주요 기능

### 1. 선수별 데이터 수집 및 갱신
- **크롤링**을 통해 각 선수의 상세 통계 및 기록 데이터를 자동으로 수집하고 정기적으로 갱신하여 최신 정보를 유지합니다.
- 수집된 데이터를 바탕으로 통계 분석을 수행하여 선수들의 기록을 쉽게 확인할 수 있습니다.

### 2. 실시간 날씨 정보 제공
- **날씨 API**를 활용하여 각 경기장별 실시간 날씨 정보를 제공합니다.
- 경기 일정 및 예보를 확인하고 날씨에 따른 경기 변동 사항을 빠르게 파악할 수 있습니다.

### 3. 최신 뉴스 제공
- **Naver News API**를 이용하여 KBO 관련 최신 기사 및 뉴스를 실시간으로 제공합니다.
- 최신 경기 소식, 선수 인터뷰 등을 신속하게 확인할 수 있습니다.

/*
 * 
 * author : linwu (http://linwu.name)
 * datetime : 2015-6-4
 */

/*Բ�ΰٷֱ�*/
var  paper =  null;
function init(b,n,t,c){
	//��ʼ��Raphael����
	this.paper = Raphael(b, 60, 60);

	//�ѵ�ͼ�Ȼ���ȥ
	this.paper.image("images/progressBg.png", 0, 0, 60, 60);

	//���ȱ�����0��1���ڱ��������ǻ�65%
	//��Ҫע�⣬������㷨��֧�ֻ�100%��Ҫ��99.99%����
	var percent = n	,
		drawPercent = percent >= 1 ? 0.9999 : percent;

	//��ʼ��������λ�ã�����ͼ
	//r1����Բ�뾶��r2����Բ�뾶
	var r1 = 25, r2 = 30, PI = Math.PI,
		p1 = {
			x:30,
			y:60
		},
		p4 = {
			x:p1.x,
			y:p1.y - r2 + r1
		},
		p2 = {
			x:p1.x + r2 * Math.sin(2 * PI * (1 - drawPercent)),
			y:p1.y - r2 + r2 * Math.cos(2 * PI * (1 - drawPercent))
		},
		p3 = {
			x:p4.x + r1 * Math.sin(2 * PI * (1 - drawPercent)),
			y:p4.y - r1 + r1 * Math.cos(2 * PI * (1 - drawPercent))
		},
		path = [
			'M', p1.x, ' ', p1.y,
			'A', r2, ' ', r2, ' 0 ', percent > 0.5 ? 1 : 0, ' 1 ', p2.x, ' ', p2.y,
			'L', p3.x, ' ', p3.y,
			'A', r1, ' ', r1, ' 0 ', percent > 0.5 ? 1 : 0, ' 0 ', p4.x, ' ', p4.y,
			'Z'
		].join('');

	//��path������ͼ�Σ�������Բ��������ֱ����ɣ������ߵ��㷨����
	this.paper.path(path)
		//��佥��ɫ����#3f0b3f��#ff66ff
		.attr({"stroke-width":0.3, "stroke":"#d2d4d8", "fill":"90-" + c});

	//��ʾ��������
	$(t).text(Math.round(percent * 100) + "%");
}

init('bg',0.4,'#txt','#f8586a');
init('bg1',0.9,'#txt1','#f8586a');
init('bg2',0.5,'#txt2','#f8586a');
init('bg3',0.6,'#txt3','#f8586a');
init('bg4',0.7,'#txt4','#f8586a');



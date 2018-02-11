import { MrCooperGitRepoSavePage } from './app.po';

describe('mr-cooper-git-repo-save App', () => {
  let page: MrCooperGitRepoSavePage;

  beforeEach(() => {
    page = new MrCooperGitRepoSavePage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
